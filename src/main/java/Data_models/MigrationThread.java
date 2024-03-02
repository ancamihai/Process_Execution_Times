package Data_models;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;

public class MigrationThread extends Thread {
    private int variable = 0;
    private double durationMigration;

    @Override
    public void run() {
        long startTime = System.nanoTime();
        variable++;
        AffinityLibrary lib = AffinityLibrary.INSTANCE;
        int pid = lib.GetCurrentThread();
        lib.SetThreadAffinityMask(new WinNT.HANDLE(new Pointer(pid)), new WinDef.DWORD(1));
        variable++;
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        durationMigration = Long.valueOf(duration).doubleValue();

    }

    public double getDurationMigration() {
        return durationMigration;
    }

    private interface AffinityLibrary extends Library {
        AffinityLibrary INSTANCE = Native.load("kernel32", AffinityLibrary.class);

        void SetThreadAffinityMask(final WinNT.HANDLE pid, final WinDef.DWORD lpProcessAffinityMask);

        int GetCurrentThread();
    }
}


