const PerformaceCalculator = require('./performaceCalculator');

module.exports = class TragedyCalculator extends PerformaceCalculator {

    get amount() {
        let result = 40000
        if (this.performance.audience > 30) {
            result += 1000 * (this.performance.audience - 30)
        }
        return result;
    }
}

