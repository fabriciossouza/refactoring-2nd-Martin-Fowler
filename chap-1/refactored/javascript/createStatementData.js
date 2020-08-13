
const ComedyCalculator = require('./comedyCalculator');
const TragedyCalculator = require('./tragedyCalculator');

module.exports = function createStatementData(invoice, plays) { 

  let statementData = {};
  statementData.customer = invoice.customer;
  statementData.performances = invoice.performances.map(enrichPerformance);
  statementData.totalVolumeCredits = totalVolumeCredits(statementData);
  statementData.totalAmount = totalAmount(statementData);
  return statementData;

  function enrichPerformance(aPerformance) {
    const calculator = createPerformaceCalculator(aPerformance, playFor(aPerformance));
    const result = Object.assign({}, aPerformance);
    result.play = calculator.play;
    result.amount = calculator.amount;
    result.volumeCredits = calculator.volumeCredits;
    return result;
  }

  function createPerformaceCalculator(aPerformance, aPlay){
    switch(aPlay.type){
      case "tragedy": return new TragedyCalculator(aPerformance, aPlay);
      case "comedy": return new ComedyCalculator(aPerformance, aPlay);
      default:
        throw new Error(`unknown type: ${aPlay.type}`)
    }
  }
  
  function playFor(aPerformance){
    return plays[aPerformance.playID];
  }

  function totalVolumeCredits(data){
    return data.performances
      .reduce((total, p) => total + p.volumeCredits, 0);
  }

  function totalAmount(data) {
    return data.performances
      .reduce((total, p) => total + p.amount, 0);
  }
}