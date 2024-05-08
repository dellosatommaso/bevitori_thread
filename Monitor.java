package com.mycompany.bevitori;

public class Monitor 
{
    private int valore;

    
    public Monitor(int valore) {
        this.valore = valore;
    }

    
    public int getValore() {
        return valore;
    }

    
    public void setValore(int valore) {
        this.valore = valore;
    }

    /**
     * gestisce l'accesso alle risorse con un Monitor che ha comne valore x>1 => verde o x=0 => rosso
     */
    /*
        synchronized così un solo tread alla volta può accedere a questo metodo, altrimenti se 
        non ci fosse il synchronized, più thread potrebbero accedere contemporaneamente a questo metodo

        fino a che valore==0 il thread rimane bloccato nel ciclo while e 
        attende che un altro thread lo risvegli con il metodo notify() dopo
        che ha finito il pitstop, quindi si viene a creare una sorta di coda.
    */
    public synchronized void P()
    {
        while (valore == 0) 
        {
            try 
            {
                System.out.println("----"+Thread.currentThread().getName() + " in attesa del rubunetto ----");
                wait();
            } 
            catch (Exception e) 
            {
                System.out.println("malfunzionamento");
            }
        }
        valore = 0; 
    }
    /**
     * setta il Monitor a verde e risveglia eventuali thread
     */
    //notify risveglia i tread in attesa
    public synchronized void V() 
    {
        valore = 1; 
        notifyAll(); 
    }
}


