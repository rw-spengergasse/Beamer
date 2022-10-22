package org.example.domain;

// PLAYGROUND
// Code zum Experimentieren und Herumspielen

public class BeamerPlayground
{
    public static void main(String[] args)
    {
        Beamer b1 = new Beamer("C2.01", 10);

        b1.ausschalten(); // Fehler: ausgeschaltet
        b1.einschalten(); // OK restzeit von 10->9

        System.out.println( b1.toString() );

        b1.reparieren(); // OK: restzeit von 9->59
        System.out.println( b1.toString() );
    }
}
