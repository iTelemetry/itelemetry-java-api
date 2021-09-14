package app.itelemetry.api.iracing.kernel;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.win32.W32APIOptions;

public interface KernelProxy extends Kernel32 {

    KernelProxy INSTANCE = Native.loadLibrary("kernel32", KernelProxy.class, W32APIOptions.DEFAULT_OPTIONS);

    HANDLE OpenFileMapping(int dwDesiredAccess, boolean bInheritHandle, String lpName);

    HANDLE OpenEvent(int i, boolean bManualReset, String lpName);

}
