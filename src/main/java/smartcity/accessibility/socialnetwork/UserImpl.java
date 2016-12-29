package smartcity.accessibility.socialnetwork;

import java.util.List;

import smartcity.accessibility.database.UserManager;
import smartcity.accessibility.exceptions.UnauthorizedAccessException;
import smartcity.accessibility.exceptions.UserNotFoundException;
import smartcity.accessibility.search.SearchQuery;

public class UserImpl implements User {
	
	private String userName;
	private String password;
	private Privilege privilegeLevel;
	private List<SearchQuery> favouriteSearchQueries;
	
	public UserImpl(String uName, String pass, Privilege p, String FavouriteQueries){
		userName = uName;
		password = pass;
		privilegeLevel = p;
		favouriteSearchQueries = SearchQuery.String2QueriesList(FavouriteQueries);
	}
	
	public UserImpl(String uName, String pass, Privilege p){
		this(uName, pass, p, "");
	}
	
	public static UserImpl DefaultUser(String uName, String pass, String FavouriteQueries){
		return new UserImpl(uName, pass, Privilege.DefaultUser, FavouriteQueries);
	}
	
	public static UserImpl RegularUser(String uName, String pass, String FavouriteQueries){
		return new UserImpl(uName, pass, Privilege.RegularUser, FavouriteQueries);
	}
	
	public static UserImpl Admin(String uName, String pass, String FavouriteQueries){
		return new UserImpl(uName, pass, Privilege.Admin, FavouriteQueries);
	}

	@Override
	public String getName() {
		return userName;
		//TODO stuff on user name for privilege level
	}
	

	@Override
	public void setName(String name) throws UnauthorizedAccessException, UserNotFoundException {
		if (privilegeLevel == Privilege.DefaultUser)
			throw(new UnauthorizedAccessException(Privilege.RegularUser));
		
		UserManager.updateUserName(this, name);
		userName = name;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Privilege getPrivilege(){
		return privilegeLevel;
	}


	@Override
	public List<SearchQuery> getFavouriteSearchQueries() {
		return favouriteSearchQueries;
	}

	@Override
	public void setFavouriteSearchQueries(String favouriteQueries) throws UserNotFoundException {
		favouriteSearchQueries = SearchQuery.String2QueriesList(favouriteQueries);		

		UserManager.updatefavouriteQueries(this, favouriteSearchQueries);
	}

	@Override
	public void setFavouriteSearchQueries(List<SearchQuery> favouriteQueries) throws UserNotFoundException {
		favouriteSearchQueries = favouriteQueries;		

		UserManager.updatefavouriteQueries(this, favouriteSearchQueries);
	}
	
	@Override
    public boolean equals(Object o) {
		return o == this || (o instanceof UserImpl && this.userName.equals(((UserImpl) o).userName)
				&& this.password.equals(((UserImpl) o).password) && this.privilegeLevel == ((UserImpl) o).privilegeLevel);
	}



}
