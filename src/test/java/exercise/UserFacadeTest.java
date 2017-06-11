package exercise;

import exercise.fakedatabase.UserFacadeFake;
import exercise.IUserFacade;
import exercise.LoginStatus;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class UserFacadeTest {

	private IUserFacade facade;

	@Before
	public void setup() {
		facade = makeUserFacade();
	}

	@Test
	public void authenticateOK() {
		LoginStatus res = facade.verifyUser("Hans", "abcde");
		assertThat(res, is(LoginStatus.OK));
	}

	@Test
	public void authenticateValidUserWrongPW() {
		LoginStatus res = facade.verifyUser("Jan", "kfjdlsjaf");
		assertThat(res, is(LoginStatus.INVALID_PASSWORD));
	}

	@Test
	public void authenticateNonExistingUser() {
		LoginStatus res = facade.verifyUser("xxxx", "kfjdlsjaf");
		assertThat(res, is(LoginStatus.UNKNOWN_USER));
	}

	public IUserFacade makeUserFacade() {
		return new UserFacadeFake();
	}

}
