
# Create with email as PK
aws dynamodb create-table \
  --table-name Users \
  --attribute-definitions AttributeName=PK,AttributeType=S \
  --key-schema AttributeName=PK,KeyType=HASH \
  --billing-mode PAY_PER_REQUEST

# Add Oscar
aws dynamodb put-item \
  --table-name Users \
  --item '{"PK": {"S": "oscar@bank.com"}, "userId": {"S": "USER#oscar"}, "firstName": {"S": "Oscar"}, "lastName": {"S": "Scorgie"}, "password": {"S": "hashed_password_123"}, "dateCreated": {"S": "2026-01-01"}, "timeCreated": {"S": "09:00:00"}, "accounts": {"S": "ACC#001,ACC#002"}}'

# Add Jane
aws dynamodb put-item \
  --table-name Users \
  --item '{"PK": {"S": "jane@bank.com"}, "userId": {"S": "USER#jane"}, "firstName": {"S": "Jane"}, "lastName": {"S": "Doe"}, "password": {"S": "hashed_password_456"}, "dateCreated": {"S": "2026-01-15"}, "timeCreated": {"S": "10:30:00"}, "accounts": {"S": "ACC#003,ACC#004"}}'


# Create with date as PK
aws dynamodb create-table \
  --table-name Analytics \
  --attribute-definitions AttributeName=PK,AttributeType=S \
  --key-schema AttributeName=PK,KeyType=HASH \
  --billing-mode PAY_PER_REQUEST

# Week 1 - April 4-10
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-04"}, "date": {"S": "2026-04-04"}, "totalLogins": {"N": "38"}, "totalTransactions": {"N": "142"}, "totalTransactionsAmount": {"N": "48320.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-05"}, "date": {"S": "2026-04-05"}, "totalLogins": {"N": "45"}, "totalTransactions": {"N": "167"}, "totalTransactionsAmount": {"N": "61450.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-06"}, "date": {"S": "2026-04-06"}, "totalLogins": {"N": "29"}, "totalTransactions": {"N": "98"}, "totalTransactionsAmount": {"N": "34210.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-07"}, "date": {"S": "2026-04-07"}, "totalLogins": {"N": "52"}, "totalTransactions": {"N": "203"}, "totalTransactionsAmount": {"N": "78900.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-08"}, "date": {"S": "2026-04-08"}, "totalLogins": {"N": "41"}, "totalTransactions": {"N": "175"}, "totalTransactionsAmount": {"N": "59340.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-09"}, "date": {"S": "2026-04-09"}, "totalLogins": {"N": "36"}, "totalTransactions": {"N": "134"}, "totalTransactionsAmount": {"N": "43670.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-10"}, "date": {"S": "2026-04-10"}, "totalLogins": {"N": "42"}, "totalTransactions": {"N": "158"}, "totalTransactionsAmount": {"N": "52750.00"}}'

# Week 2 - April 11-17
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-11"}, "date": {"S": "2026-04-11"}, "totalLogins": {"N": "55"}, "totalTransactions": {"N": "189"}, "totalTransactionsAmount": {"N": "67320.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-12"}, "date": {"S": "2026-04-12"}, "totalLogins": {"N": "48"}, "totalTransactions": {"N": "201"}, "totalTransactionsAmount": {"N": "71840.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-13"}, "date": {"S": "2026-04-13"}, "totalLogins": {"N": "33"}, "totalTransactions": {"N": "112"}, "totalTransactionsAmount": {"N": "38920.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-14"}, "date": {"S": "2026-04-14"}, "totalLogins": {"N": "61"}, "totalTransactions": {"N": "224"}, "totalTransactionsAmount": {"N": "89340.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-15"}, "date": {"S": "2026-04-15"}, "totalLogins": {"N": "44"}, "totalTransactions": {"N": "178"}, "totalTransactionsAmount": {"N": "63210.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-16"}, "date": {"S": "2026-04-16"}, "totalLogins": {"N": "39"}, "totalTransactions": {"N": "156"}, "totalTransactionsAmount": {"N": "54780.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-17"}, "date": {"S": "2026-04-17"}, "totalLogins": {"N": "57"}, "totalTransactions": {"N": "198"}, "totalTransactionsAmount": {"N": "74560.00"}}'

# Week 3 - April 18-24
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-18"}, "date": {"S": "2026-04-18"}, "totalLogins": {"N": "62"}, "totalTransactions": {"N": "215"}, "totalTransactionsAmount": {"N": "82340.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-19"}, "date": {"S": "2026-04-19"}, "totalLogins": {"N": "47"}, "totalTransactions": {"N": "183"}, "totalTransactionsAmount": {"N": "65430.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-20"}, "date": {"S": "2026-04-20"}, "totalLogins": {"N": "35"}, "totalTransactions": {"N": "121"}, "totalTransactionsAmount": {"N": "41230.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-21"}, "date": {"S": "2026-04-21"}, "totalLogins": {"N": "58"}, "totalTransactions": {"N": "209"}, "totalTransactionsAmount": {"N": "79870.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-22"}, "date": {"S": "2026-04-22"}, "totalLogins": {"N": "43"}, "totalTransactions": {"N": "171"}, "totalTransactionsAmount": {"N": "58920.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-23"}, "date": {"S": "2026-04-23"}, "totalLogins": {"N": "37"}, "totalTransactions": {"N": "145"}, "totalTransactionsAmount": {"N": "49670.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-24"}, "date": {"S": "2026-04-24"}, "totalLogins": {"N": "66"}, "totalTransactions": {"N": "231"}, "totalTransactionsAmount": {"N": "93450.00"}}'

# Week 4 - April 25 - May 1
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-25"}, "date": {"S": "2026-04-25"}, "totalLogins": {"N": "51"}, "totalTransactions": {"N": "192"}, "totalTransactionsAmount": {"N": "69870.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-26"}, "date": {"S": "2026-04-26"}, "totalLogins": {"N": "44"}, "totalTransactions": {"N": "168"}, "totalTransactionsAmount": {"N": "57340.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-27"}, "date": {"S": "2026-04-27"}, "totalLogins": {"N": "38"}, "totalTransactions": {"N": "139"}, "totalTransactionsAmount": {"N": "46120.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-28"}, "date": {"S": "2026-04-28"}, "totalLogins": {"N": "59"}, "totalTransactions": {"N": "217"}, "totalTransactionsAmount": {"N": "84560.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-29"}, "date": {"S": "2026-04-29"}, "totalLogins": {"N": "53"}, "totalTransactions": {"N": "196"}, "totalTransactionsAmount": {"N": "72340.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-04-30"}, "date": {"S": "2026-04-30"}, "totalLogins": {"N": "46"}, "totalTransactions": {"N": "174"}, "totalTransactionsAmount": {"N": "61780.00"}}'
aws dynamodb put-item --table-name Analytics --item '{"PK": {"S": "2026-05-01"}, "date": {"S": "2026-05-01"}, "totalLogins": {"N": "64"}, "totalTransactions": {"N": "228"}, "totalTransactionsAmount": {"N": "91230.00"}}'

# Create Transactions table
aws dynamodb create-table \
  --table-name Transactions \
  --attribute-definitions AttributeName=PK,AttributeType=S \
  --key-schema AttributeName=PK,KeyType=HASH \
  --billing-mode PAY_PER_REQUEST

# April 27
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-27-001"}, "date": {"S": "2026-04-27"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#001"}, "toAccount": {"S": "ACC#003"}, "amount": {"N": "450.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-27-002"}, "date": {"S": "2026-04-27"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#003"}, "toAccount": {"S": "ACC#002"}, "amount": {"N": "320.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-27-003"}, "date": {"S": "2026-04-27"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#002"}, "toAccount": {"S": "ACC#004"}, "amount": {"N": "890.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-27-004"}, "date": {"S": "2026-04-27"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#004"}, "toAccount": {"S": "ACC#001"}, "amount": {"N": "215.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-27-005"}, "date": {"S": "2026-04-27"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#001"}, "toAccount": {"S": "ACC#003"}, "amount": {"N": "670.00"}}'

# April 26
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-26-001"}, "date": {"S": "2026-04-26"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#001"}, "toAccount": {"S": "ACC#003"}, "amount": {"N": "780.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-26-002"}, "date": {"S": "2026-04-26"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#004"}, "toAccount": {"S": "ACC#002"}, "amount": {"N": "430.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-26-003"}, "date": {"S": "2026-04-26"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#002"}, "toAccount": {"S": "ACC#004"}, "amount": {"N": "920.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-26-004"}, "date": {"S": "2026-04-26"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#003"}, "toAccount": {"S": "ACC#001"}, "amount": {"N": "340.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-26-005"}, "date": {"S": "2026-04-26"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#001"}, "toAccount": {"S": "ACC#003"}, "amount": {"N": "560.00"}}'

# April 25
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-25-001"}, "date": {"S": "2026-04-25"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#001"}, "toAccount": {"S": "ACC#003"}, "amount": {"N": "1200.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-25-002"}, "date": {"S": "2026-04-25"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#004"}, "toAccount": {"S": "ACC#002"}, "amount": {"N": "875.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-25-003"}, "date": {"S": "2026-04-25"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#002"}, "toAccount": {"S": "ACC#004"}, "amount": {"N": "430.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-25-004"}, "date": {"S": "2026-04-25"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#003"}, "toAccount": {"S": "ACC#001"}, "amount": {"N": "690.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-25-005"}, "date": {"S": "2026-04-25"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#001"}, "toAccount": {"S": "ACC#003"}, "amount": {"N": "950.00"}}'

# April 24
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-24-001"}, "date": {"S": "2026-04-24"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#001"}, "toAccount": {"S": "ACC#003"}, "amount": {"N": "540.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-24-002"}, "date": {"S": "2026-04-24"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#004"}, "toAccount": {"S": "ACC#002"}, "amount": {"N": "1100.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-24-003"}, "date": {"S": "2026-04-24"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#002"}, "toAccount": {"S": "ACC#004"}, "amount": {"N": "760.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-24-004"}, "date": {"S": "2026-04-24"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#003"}, "toAccount": {"S": "ACC#001"}, "amount": {"N": "380.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-24-005"}, "date": {"S": "2026-04-24"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#001"}, "toAccount": {"S": "ACC#003"}, "amount": {"N": "920.00"}}'

# April 23
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-23-001"}, "date": {"S": "2026-04-23"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#003"}, "toAccount": {"S": "ACC#002"}, "amount": {"N": "410.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-23-002"}, "date": {"S": "2026-04-23"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#002"}, "toAccount": {"S": "ACC#004"}, "amount": {"N": "630.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-23-003"}, "date": {"S": "2026-04-23"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#004"}, "toAccount": {"S": "ACC#001"}, "amount": {"N": "280.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-23-004"}, "date": {"S": "2026-04-23"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#001"}, "toAccount": {"S": "ACC#003"}, "amount": {"N": "750.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-23-005"}, "date": {"S": "2026-04-23"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#003"}, "toAccount": {"S": "ACC#002"}, "amount": {"N": "490.00"}}'

# April 22
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-22-001"}, "date": {"S": "2026-04-22"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#001"}, "toAccount": {"S": "ACC#004"}, "amount": {"N": "870.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-22-002"}, "date": {"S": "2026-04-22"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#004"}, "toAccount": {"S": "ACC#002"}, "amount": {"N": "320.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-22-003"}, "date": {"S": "2026-04-22"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#002"}, "toAccount": {"S": "ACC#003"}, "amount": {"N": "1050.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-22-004"}, "date": {"S": "2026-04-22"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#003"}, "toAccount": {"S": "ACC#001"}, "amount": {"N": "460.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-22-005"}, "date": {"S": "2026-04-22"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#001"}, "toAccount": {"S": "ACC#003"}, "amount": {"N": "730.00"}}'

# April 21
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-21-001"}, "date": {"S": "2026-04-21"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#004"}, "toAccount": {"S": "ACC#001"}, "amount": {"N": "550.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-21-002"}, "date": {"S": "2026-04-21"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#002"}, "toAccount": {"S": "ACC#003"}, "amount": {"N": "980.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-21-003"}, "date": {"S": "2026-04-21"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#003"}, "toAccount": {"S": "ACC#002"}, "amount": {"N": "340.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-21-004"}, "date": {"S": "2026-04-21"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#001"}, "toAccount": {"S": "ACC#004"}, "amount": {"N": "810.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-21-005"}, "date": {"S": "2026-04-21"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#004"}, "toAccount": {"S": "ACC#002"}, "amount": {"N": "620.00"}}'

# April 20
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-20-001"}, "date": {"S": "2026-04-20"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#001"}, "toAccount": {"S": "ACC#003"}, "amount": {"N": "470.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-20-002"}, "date": {"S": "2026-04-20"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#003"}, "toAccount": {"S": "ACC#001"}, "amount": {"N": "890.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-20-003"}, "date": {"S": "2026-04-20"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#002"}, "toAccount": {"S": "ACC#004"}, "amount": {"N": "310.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-20-004"}, "date": {"S": "2026-04-20"}, "fromUserId": {"S": "USER#jane"}, "toUserId": {"S": "USER#oscar"}, "fromAccount": {"S": "ACC#004"}, "toAccount": {"S": "ACC#002"}, "amount": {"N": "650.00"}}'
aws dynamodb put-item --table-name Transactions --item '{"PK": {"S": "2026-04-20-005"}, "date": {"S": "2026-04-20"}, "fromUserId": {"S": "USER#oscar"}, "toUserId": {"S": "USER#jane"}, "fromAccount": {"S": "ACC#001"}, "toAccount": {"S": "ACC#003"}, "amount": {"N": "520.00"}}'