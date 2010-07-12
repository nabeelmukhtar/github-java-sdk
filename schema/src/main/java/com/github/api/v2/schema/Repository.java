/**
 * 
 */
package com.github.api.v2.schema;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nmukhtar
 *
 */
public class Repository extends SchemaEntity {
	public enum Visibility implements ValueEnum {
		PUBLIC("public"), PRIVATE("private");
		
	    /** The Constant stringToEnum. */
		private static final Map<String, Visibility> stringToEnum = new HashMap<String, Visibility>();

		static { // Initialize map from constant name to enum constant
			for (Visibility op : values()) {
				stringToEnum.put(op.value(), op);
			}
		}
		
	    /** The value. */
	    private final String value;
	    
	    /**
	     * Instantiates a new blog sort order.
	     * 
	     * @param value the value
	     */
	    Visibility(String value) {
	        this.value = value;
	    }

		@Override
		public String value() {
			return value;
		}
		
		/**
		 * From value.
		 * 
		 * @param value the value
		 * 
		 * @return the blog sort order
		 */
		public static Visibility fromValue(String value) {
			return stringToEnum.get(value);
		}
	}
	
	public static final String MASTER = "master";

	/**
	 * 
	 */
	private static final long serialVersionUID = 9155892708485181542L;
	private int watchers;
	private String owner;
	private String name;
	private String description;
	private Visibility visibility;
	private String url;
	private int openIssues;
	private boolean fork;
	private String homepage;
	private int forks;
	private double score;
	private int actions;
	private long size;
	private Language language;
	private int followers;
	private String username;
	private String type;
	private String id;
	private Date pushed;
	private Date created;
	private String source;
	private String parent;
	private boolean hasWiki;
	private boolean hasIssues;
	private boolean hasDownloads;
	
	/**
	 * @return the watchers
	 */
	public int getWatchers() {
		return watchers;
	}
	/**
	 * @param watchers the watchers to set
	 */
	public void setWatchers(int watchers) {
		this.watchers = watchers;
	}
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the visibiity
	 */
	public Visibility getVisibility() {
		return visibility;
	}
	/**
	 * @param visibiity the visibiity to set
	 */
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the openIssues
	 */
	public int getOpenIssues() {
		return openIssues;
	}
	/**
	 * @param openIssues the openIssues to set
	 */
	public void setOpenIssues(int openIssues) {
		this.openIssues = openIssues;
	}
	/**
	 * @return the fork
	 */
	public boolean isFork() {
		return fork;
	}
	/**
	 * @param fork the fork to set
	 */
	public void setFork(boolean fork) {
		this.fork = fork;
	}
	/**
	 * @return the homepage
	 */
	public String getHomepage() {
		return homepage;
	}
	/**
	 * @param homepage the homepage to set
	 */
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	/**
	 * @return the forks
	 */
	public int getForks() {
		return forks;
	}
	/**
	 * @param forks the forks to set
	 */
	public void setForks(int forks) {
		this.forks = forks;
	}
	/**
	 * @return the score
	 */
	public double getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(double score) {
		this.score = score;
	}
	/**
	 * @return the actions
	 */
	public int getActions() {
		return actions;
	}
	/**
	 * @param actions the actions to set
	 */
	public void setActions(int actions) {
		this.actions = actions;
	}
	/**
	 * @return the size
	 */
	public long getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(long size) {
		this.size = size;
	}
	/**
	 * @return the language
	 */
	public Language getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}
	/**
	 * @return the followers
	 */
	public int getFollowers() {
		return followers;
	}
	/**
	 * @param followers the followers to set
	 */
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the pushed
	 */
	public Date getPushed() {
		return pushed;
	}
	/**
	 * @param pushed the pushed to set
	 */
	public void setPushed(Date pushed) {
		this.pushed = pushed;
	}
	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the parent
	 */
	public String getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}
	/**
	 * @return the hasWiki
	 */
	public boolean isHasWiki() {
		return hasWiki;
	}
	/**
	 * @param hasWiki the hasWiki to set
	 */
	public void setHasWiki(boolean hasWiki) {
		this.hasWiki = hasWiki;
	}
	/**
	 * @return the hasIssues
	 */
	public boolean isHasIssues() {
		return hasIssues;
	}
	/**
	 * @param hasIssues the hasIssues to set
	 */
	public void setHasIssues(boolean hasIssues) {
		this.hasIssues = hasIssues;
	}
	/**
	 * @return the hasDownloads
	 */
	public boolean isHasDownloads() {
		return hasDownloads;
	}
	/**
	 * @param hasDownloads the hasDownloads to set
	 */
	public void setHasDownloads(boolean hasDownloads) {
		this.hasDownloads = hasDownloads;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Repository [actions=" + actions + ", created=" + created
				+ ", description=" + description + ", followers=" + followers
				+ ", fork=" + fork + ", forks=" + forks + ", hasDownloads="
				+ hasDownloads + ", hasIssues=" + hasIssues + ", hasWiki="
				+ hasWiki + ", homepage=" + homepage + ", id=" + id
				+ ", language=" + language + ", name=" + name + ", openIssues="
				+ openIssues + ", owner=" + owner + ", parent=" + parent
				+ ", pushed=" + pushed + ", score=" + score + ", size=" + size
				+ ", source=" + source + ", type=" + type + ", url=" + url
				+ ", username=" + username + ", visibiity=" + visibility
				+ ", watchers=" + watchers + "]";
	}
}
