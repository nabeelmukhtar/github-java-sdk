# GitHub Java SDK
## Description
This project provides a Java wrapper for the [GitHub API v.2.0](http://develop.github.com/).
 
## License
This project is open source with [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).
 
## Requirements
This project has only one dependency on Gson which can be downloaded [here](http://code.google.com/p/google-gson/).

The library is supported on AppEngine and Android platforms as well.
 
## Key Features
The library implements all the methods of GitHub API v.2.0. Additionally it has methods for reading various atom feeds from the GitHub site. It also has a method for downloading the source as a zip archive.
The library is divided into various services each implementing a specific portion of the API.

* UserService: Provides methods of the [User API](http://develop.github.com/p/users.html).
* IssueService: Provides methods of the [Issues API](http://develop.github.com/p/issues.html).
* GistService: Provides methods of the [Gist API](http://develop.github.com/p/gist.html).
* NetworkService: Provides methods of the [Network API](http://develop.github.com/p/network.html).
* RepositoryService: Provides methods of the [Repository API](http://develop.github.com/p/repo.html).
* CommitService: Provides methods of the [Commit API](http://develop.github.com/p/commits.html).
* ObjectService: Provides methods of the [Object API](http://develop.github.com/p/object.html).
* OrganizationService: Provides methods of the [Organization API](http://develop.github.com/p/orgs.html).
* PullRequestService: Provides methods of the [Pull Request API](http://develop.github.com/p/pulls.html).
* JobService: Provides methods of the [Job API](http://jobs.github.com/api).
* FeedService: Provides methods for reading the Atom/RSS feeds.
* OAuthService: Provides methods for OAuth 2.0 authentication and authorization.

 
## Usage
Most of the methods of the API can be invoked without using any authentication. However some need the user to be authenticated.
### Typical
The typical usage includes the creation of the appropriate servive using a factory and invoking the methods of that service.
	GitHubServiceFactory factory = GitHubServiceFactory.newInstance();
	RepositoryService service = factory.createRepositoryService();
	List<Repository> repositories = service.searchRepositories("hadoop");
	for (Repository repository : repositories) {
		printResult(repository);
	}
	Repository repository = service.getRepository("nabeelmukhtar", "github-java-sdk");
	printResult(repository);
### Authenticated
Authenticated usage is not very different from typical usage. Before calling any service method that requires authentication, you have to set the credentials on the service instance. Subsequent method calls from the same instance will not need further authentication.
	GitHubServiceFactory factory = GitHubServiceFactory.newInstance();
	RepositoryService service = factory.createRepositoryService();
	service.setAuthentication(new LoginTokenAuthentication("nabeelmukhtar", "xxx-xxx-xxx"));
	service.createRepository("new-repo", "Creating new repository.", "http://www.example.com", Repository.Visibility.PUBLIC);
## More Information
For more information see the following wiki pages.

* [Getting Started](http://wiki.github.com/nabeelmukhtar/github-java-sdk/getting-started)
* [Authentication](http://wiki.github.com/nabeelmukhtar/github-java-sdk/authentication)
* [Asynchronous API](http://wiki.github.com/nabeelmukhtar/github-java-sdk/asynchronous-api)
* [Maven Support](http://wiki.github.com/nabeelmukhtar/github-java-sdk/maven-support)
* [Spring Configuration](http://wiki.github.com/nabeelmukhtar/github-java-sdk/spring-configuration)
* [Android Configuration](http://wiki.github.com/nabeelmukhtar/github-java-sdk/android-configuration)
* [API Design](http://wiki.github.com/nabeelmukhtar/github-java-sdk/api-design)
