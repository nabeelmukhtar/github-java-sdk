/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.github.api.v2.schema;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum Language.
 */
public enum Language implements ValueEnum {
	
	/** The Action script. */
	ActionScript("ActionScript"),
	
	/** The Arc. */
	Arc("Arc"),
	
	/** The ASP. */
	ASP("ASP"),
	
	/** The Assembly. */
	Assembly("Assembly"),
	
	/** The Boo. */
	Boo("Boo"),
	
	/** The C. */
	C("C"),
	
	/** The C_ sharp. */
	C_SHARP("C#"),
	
	/** The CPP. */
	CPP("C++"),
	
	/** The Clojure. */
	Clojure("Clojure"),
	
	/** The Coffee script. */
	CoffeeScript("CoffeeScript"),
	
	/** The Cold fusion. */
	ColdFusion("ColdFusion"),
	
	/** The Common lisp. */
	CommonLisp("Common Lisp"),
	
	/** The D. */
	D("D"),
	
	/** The Delphi. */
	Delphi("Delphi"),
	
	/** The Duby. */
	Duby("Duby"),
	
	/** The Eiffel. */
	Eiffel("Eiffel"),
	
	/** The Emacs lisp. */
	EmacsLisp("Emacs Lisp"),
	
	/** The Erlang. */
	Erlang("Erlang"),
	
	/** The F_ sharp. */
	F_SHARP("F#"),
	
	/** The FORTRAN. */
	FORTRAN("FORTRAN"),
	
	/** The Go. */
	Go("Go"),
	
	/** The Groovy. */
	Groovy("Groovy"),
	
	/** The Haskell. */
	Haskell("Haskell"),
	
	/** The Ha xe. */
	HaXe("HaXe"),
	
	/** The Io. */
	Io("Io"),
	
	/** The Java. */
	Java("Java"),
	
	/** The Java script. */
	JavaScript("JavaScript"),
	
	/** The Lua. */
	Lua("Lua"),
	
	/** The Max_ msp. */
	Max_MSP("Max/MSP"),
	
	/** The Nu. */
	Nu("Nu"),
	
	/** The Objective_ c. */
	Objective_C("Objective-C"),
	
	/** The Objective_ j. */
	Objective_J("Objective-J"),
	
	/** The O caml. */
	OCaml("OCaml"),
	
	/** The ooc. */
	ooc("ooc"),
	
	/** The Perl. */
	Perl("Perl"),
	
	/** The PHP. */
	PHP("PHP"),
	
	/** The Pure_ data. */
	Pure_Data("Pure Data"),
	
	/** The Python. */
	Python("Python"),
	
	/** The R. */
	R("R"),
	
	/** The Racket. */
	Racket("Racket"),
	
	/** The Ruby. */
	Ruby("Ruby"),
	
	/** The Scala. */
	Scala("Scala"),
	
	/** The Scheme. */
	Scheme("Scheme"),
	
	/** The sclang. */
	sclang("sclang"),
	
	/** The Self. */
	Self("Self"),
	
	/** The Shell. */
	Shell("Shell"),
	
	/** The Smalltalk. */
	Smalltalk("Smalltalk"),
	
	/** The Super collider. */
	SuperCollider("SuperCollider"),
	
	/** The Tcl. */
	Tcl("Tcl"),
	
	/** The Vala. */
	Vala("Vala"),
	
	/** The Verilog. */
	Verilog("Verilog"),
	
	/** The VHDL. */
	VHDL("VHDL"),
	
	/** The Vim l. */
	VimL("VimL"),
	
	/** The Visual basic. */
	VisualBasic("Visual Basic");
	
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
	 * Instantiates a new language.
	 * 
	 * @param value
	 *            the value
	 */
    Language(String value) {
        this.value = value;
    }

	/* (non-Javadoc)
	 * @see com.github.api.v2.schema.ValueEnum#value()
	 */
	@Override
	public String value() {
		return value;
	}
	
	/**
	 * From value.
	 * 
	 * @param value
	 *            the value
	 * 
	 * @return the language
	 */
	public static Language fromValue(String value) {
		return stringToEnum.get(value);
	}
}
