public class Main
{
    GUI[] gui = new GUI[100];
    int gPointer = 0;

    public static void main()
    {
        Main m = new Main();
        m.run();
    }

    public void run()
    {
        for(int i = 0; i < 100; i++)
        {
            GUI g = new GUI();
            gui[gPointer] = g;
            g.run();
            try
            {
                Thread.sleep(10);
            }
            catch(Exception e)
            {

            }
        }

    }
}