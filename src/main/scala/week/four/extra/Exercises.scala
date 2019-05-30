package week.four.extra

import java.time.Instant
import java.util.UUID

object Exercises extends App {
  /**
    We're designing a small ( bad ) authentication system.
    An user has:
      1. firstname
      2. lastname
      3. password
      4. bearer token associated with him - use UUID.randomUUID.toString() to generate one
      5. expiration time - use Instant.now.plusSeconds(300) - this gives the time that it will be in 5 mins ofc

    There are 3 possible roles for an user:
      1. AdminUser
      2. EngineerUser
      3. CallCenterUser

    For all the following functions, have a List of acceptable values:

    For example, for the register, validation on firstname: List("valid-firstname1", valid-firstname2", valid-firstname3")

    For example, for the login: List(("Firstname1", "Lastname1", "password1"), ("Firstname2", "Lastname2", "password2"), ("Firstname3", "Lastname3", "password3"))

    There will be 2 functions which deal with users register and loging:
      1. Register
                - parameters are: a firstname, lastname and password
                - the function validates all the fields ( meaning there will be a separate function for every field: validateFirstname, validateLastname, validatePassword )
                - returns the user with a random bearer token and the appropiate expiration time
      2. Login: - returns an Option[User]
                - parameters are: a firstname, lastname and password, knownUsers
                - returns the user with the bearer token and expiration time

    As a final exercise, try registering multiple users and then calling the login for 1 registered user and 1 unregistered user.
    */


  case class User(firstname: String, lastname: String, password: String, bearerToken: String, expirationTime: Instant)

  def register(firstname: String, lastname: String, password: String): Option[User] = ???

  def login(user: User, knownUsers: List[User]): Option[User] = ???

  val storage = Map(("Jack", "Witchell") -> ((password: String) => User("jack", "witchell", password, UUID.randomUUID().toString, Instant.now.plusSeconds(300))))

}
