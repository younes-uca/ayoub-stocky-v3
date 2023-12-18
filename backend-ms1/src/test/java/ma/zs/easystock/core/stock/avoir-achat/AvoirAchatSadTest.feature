Feature: AvoirAchat

  Background:
    * call read('karate-config.js')
    * call read('db_cleaner.js')
    * url avoirAchatUrl
    * header Content-Type = 'application/json'

    * def postBody = read('AvoirAchatSave.json')
    * def FindAllSchema = read('AvoirAchatSchema.json')
    * def uuid = function() { return '' + java.util.UUID.randomUUID(); }
    * postBody.numeroFactureAvoirFournisseur = uuid()

  @duplicate
  Scenario Outline: POST AvoirAchat Twice with same numeroFactureAvoirFournisseur - expect <responseCode> as response code
    * postBody.code = uniqueId
    * def count = db.readValue('select count(*) FROM item.avoir_achat')

    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * request postBody
    * method POST
    * status <responseCode>
    * eval if(__num==1 && count != db.readValue('select count(*) FROM item.avoir_achat')) karate.fail("avoir_achat count values in DB are different")

    Examples:
      | responseCode |
      | 201          |
      | 226          |

  Scenario: Fail - GetByID Not Found

    * path 'id', 99999999
    * header Authorization = 'Bearer ' + adminToken
    * method GET
    * status 404
    * match response.length == 0



  Scenario: Fail - POST AvoirAchat without Body

    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method POST
    * status 400
    * match response.error == "Bad Request"



  Scenario: Fail - POST AvoirAchat without Authorization

    * path ''
    * header Authorization = 'Bearer unvalid'
    * request postBody
    * method POST
    * status 500



  Scenario: Fail - Save AvoirAchat with method PATCH

    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method PATCH
    * status 405
    * match response.error == "Method Not Allowed"
