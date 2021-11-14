package lapr.project.auth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserSessionTest {

    @Test
    void UserSessionNullTest(){
        try{
            UserSession userSession = new UserSession(null);
        }catch (Exception e){
            assertEquals("Argument cannot be null.", e.getMessage());
        }
    }

    @Test
    void isLoggedIn() {
        Email email = new Email("test@gmail.com");
        Password password = new Password("123");
        String name = "testname";

        User user = new User(email, password, name);

        UserSession userSession = new UserSession(user);

        assertTrue(userSession.isLoggedIn());
    }

    @Test
    void isLoggedInWithRole() {
        Email email = new Email("test@gmail.com");
        Password password = new Password("123");
        String name = "testname";

        User user = new User(email, password, name);

        UserRole userRole = new UserRole("1", "Manager");
        user.addRole(userRole);

        UserSession userSession = new UserSession(user);

        assertTrue(userSession.isLoggedInWithRole("1"));
    }

    @Test
    void getUserName() {
        Email email = new Email("test@gmail.com");
        Password password = new Password("123");
        String name = "testname";

        User user = new User(email, password, name);

        UserRole userRole = new UserRole("1", "Manager");
        user.addRole(userRole);

        UserSession userSession = new UserSession(user);

        assertEquals(userSession.getUserName(), "testname");
    }

    @Test
    void getUserId() {
        Email email = new Email("test@gmail.com");
        Password password = new Password("123");
        String name = "testname";

        User user = new User(email, password, name);

        UserRole userRole = new UserRole("1", "Manager");
        user.addRole(userRole);

        UserSession userSession = new UserSession(user);

        assertEquals(userSession.getUserId(), email);
    }

    @Test
    void testToString() {
        Email email = new Email("test@gmail.com");
        Password password = new Password("123");
        String name = "testname";

        User user = new User(email, password, name);

        UserRole userRole = new UserRole("1", "Manager");
        user.addRole(userRole);

        UserSession userSession = new UserSession(user);

        String expected = "UserSession{user="+user+"}";

        assertEquals(expected, userSession.toString());
    }
}