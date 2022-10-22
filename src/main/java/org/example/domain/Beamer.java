package org.example.domain;

public class Beamer
{
    private String raum; // not null, not blank, mind 2
    private boolean eingeschaltet;
    private int restzeit; // [0, 1000]

    // ctor
    public Beamer(String raum, int restzeit)
    {
        setRaum(raum);
        setRestzeit(restzeit);
    }


    // getter
    public String getRaum()
    {
        return raum;
    }

    public boolean isEingeschaltet()
    {
        return eingeschaltet;
    }

    public int getRestzeit()
    {
        return restzeit;
    }


    // setter
    public void setRaum(String raum)
    {
        if (raum != null)
        {
            String raumStripped = raum.strip();

            if ( raumStripped.length() >= 2 )
            {
                this.raum = raumStripped;
            }
            else
            {
                System.out.println("Fehler: raum mind. 2 Zeichen");
            }
        }
        else
        {
            System.out.println("Fehler: raum ist null");
        }
    }

    public void setRestzeit(int restzeit)
    {
        if (restzeit >= 0 && restzeit <= 1000)
        {
            this.restzeit = restzeit;
        }
        else
        {
            System.out.println("Fehler: restzeit mind. 0 und max. 1000");
        }
    }

    public void einschalten()
    {
        if (! eingeschaltet)
        {
            if (restzeit > 0)
            {
                // restzeit = restzeit - 1;
                // restzeit -= 1;
                restzeit--;
                eingeschaltet = true;
            }
            else
            {
                System.out.println("Fehler: ist kaputt");
            }
        }
        else
        {
            System.out.println("Fehler: schon eingeschaltet");
        }
    }


    public void ausschalten()
    {
        if (eingeschaltet)
        {
            eingeschaltet = false;
        }
        else
        {
            System.out.println("Fehler: schon ausgeschaltet");
        }
    }


    // All-Or-Nothing
    public void reparieren()
    {
        // restzeit = restzeit + 50;
        if (restzeit <= 950)
        {
            restzeit += 50;
        }
        else
        {
            System.out.println("Fehler: kann keine weiteren 50 Einheiten rep. werden.");
        }
    }


    // Best-Effort
    public void reparierenV2()
    {
        // being optimistic
        restzeit += 50;

        if (restzeit > 1000)
        {
            restzeit = 1000;
        }
    }

    public void reparierenV3()
    {
        // being cautious
        if (restzeit <= 950)
        {
            restzeit += 50;
        }
        else
        {
            restzeit = 1000;
        }
    }

    public void runterwerfen()
    {
        restzeit = 0;
        eingeschaltet = false;
    }


    public String toString_OLD()
    {
        String eingeschaltetText;

        if (eingeschaltet)
        {
            eingeschaltetText = "eingeschaltet";
        }
        else
        {
            eingeschaltetText = "ausgeschaltet";
        }

        // ternary operator
        // String eingeschaltetText = eingeschaltet ? "eingeschaltet" : "ausgeschaltet";

        String str =
            "Beamer in Raum " +raum+
                " ist " +eingeschaltetText+
                "mit restzeit von " +restzeit;

        return str;
    }

    public String toString_OLD2()
    {
        return
            "Beamer in Raum " +raum+
                " ist " +getEingeschaltetText()+
                "mit restzeit von " +restzeit;
    }

    public String toString()
    {
        // %d, %f, %s
        return String.format(
            "Beamer in Raum %s ist %s mit restzeit von %d",
            raum, getEingeschaltetText(), restzeit);

        /*
        return
            "Beamer in Raum " +raum+
            " ist " +getEingeschaltetText()+
            "mit restzeit von " +restzeit;
            */
    }

    // DRY
    // Source of Truth
    private String getEingeschaltetText()
    {
        return eingeschaltet ? "eingeschaltet" : "ausgeschaltet";
    }
}
