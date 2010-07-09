/**
 * 
 */
package com.github.api.v2.schema;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nmukhtar
 *
 */
public enum Language implements ValueEnum {
	ActionScript("ActionScript"),
	Arc("Arc"),
	ASP("ASP"),
	Assembly("Assembly"),
	Boo("Boo"),
	C("C"),
	C_SHARP("C#"),
	CPP("C++"),
	Clojure("Clojure"),
	CoffeeScript("CoffeeScript"),
	ColdFusion("ColdFusion"),
	CommonLisp("Common Lisp"),
	D("D"),
	Delphi("Delphi"),
	Duby("Duby"),
	Eiffel("Eiffel"),
	EmacsLisp("Emacs Lisp"),
	Erlang("Erlang"),
	F_SHARP("F#"),
	FORTRAN("FORTRAN"),
	Go("Go"),
	Groovy("Groovy"),
	Haskell("Haskell"),
	HaXe("HaXe"),
	Io("Io"),
	Java("Java"),
	JavaScript("JavaScript"),
	Lua("Lua"),
	Max_MSP("Max/MSP"),
	Nu("Nu"),
	Objective_C("Objective-C"),
	Objective_J("Objective-J"),
	OCaml("OCaml"),
	ooc("ooc"),
	Perl("Perl"),
	PHP("PHP"),
	Pure_Data("Pure Data"),
	Python("Python"),
	R("R"),
	Racket("Racket"),
	Ruby("Ruby"),
	Scala("Scala"),
	Scheme("Scheme"),
	sclang("sclang"),
	Self("Self"),
	Shell("Shell"),
	Smalltalk("Smalltalk"),
	SuperCollider("SuperCollider"),
	Tcl("Tcl"),
	Vala("Vala"),
	Verilog("Verilog"),
	VHDL("VHDL"),
	VimL("VimL"),
	Visual_Basic("Visual Basic");
	
    /** The Constant stringToEnum. */
	private static final Map<String, Language> stringToEnum = new HashMap<String, Language>();

	static { // Initialize map from constant name to enum constant
		for (Language op : values()) {
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
    Language(String value) {
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
	public static Language fromValue(String value) {
		return stringToEnum.get(value);
	}
}
