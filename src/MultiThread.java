public class MultiThread extends Thread
{
    @Override
    public void run()
    {
        GUI g = new GUI();
        g.run();
    }
}
