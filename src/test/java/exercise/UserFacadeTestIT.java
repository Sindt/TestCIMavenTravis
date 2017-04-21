package exercise;

import exercise.realdatabase.UserFacadeRealDB;

public class UserFacadeTestIT extends UserFacadeTest {
	@Override
	public IUserFacade makeUserFacade() {
		return new UserFacadeRealDB("pu_localDB");
	}

}
