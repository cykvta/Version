package cykuta.etheriacore.utils;

import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class TimeLapse extends BukkitRunnable {
    private final World world;
    private static boolean isRunning = false;
    private final int targetTime;

    public TimeLapse(World world, int targetTime) {
        this.world = world;
        this.targetTime = targetTime;
    }

    @Override
    public void run() {
        isRunning = true;
        int timeLapseSpeed = 10 * 20;
        long currentTime = world.getTime();

        // Check if is night
        long t = currentTime + (long) timeLapseSpeed;
        world.setTime(t);

        // Check if time is close (1000) to target time
        if (currentTime > (targetTime - 1000) && currentTime < (targetTime + 1000)) {
            isRunning = false;
            this.cancel();
        }
    }

    public static boolean isRunning() {
        return isRunning;
    }
}
