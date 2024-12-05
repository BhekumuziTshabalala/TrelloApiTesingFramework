Feature: Validating Create Board API
  Scenario: Verify if the board is successfully created using the Create Board API
  Given a Create booking payload "newBoard"
  When the user sends a "Post" request to the "CreateBoardAPI"
  Then the API call is successful with a status code "200"