# Token Utility

* This is a convenience/utility micro service that provides a Swagger UI to obtain an OAuth2 token 
from the auth server using Swagger.  
* A token requires valid auth server credentials, username and password
* The response will return the scopes, expiration seconds, and both an auth 
and refresh JWT token.
* The intended use is to copy and paste the JWT token into the micro service Swagger UI for testing

