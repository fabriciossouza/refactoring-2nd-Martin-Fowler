const {
  invoice,
  plays
} = require('../../data/data')

const statement = require('./statement.js')
const print = console.log

print(statement(invoice, plays))