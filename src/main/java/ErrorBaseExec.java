import java.io.*;

public class ErrorBaseExec {
    public static byte[] readBytes(InputStream in) throws IOException {
        BufferedInputStream bufin = new BufferedInputStream(in);
        int buffSize = 1024;
        ByteArrayOutputStream out = new ByteArrayOutputStream(buffSize);
        byte[] temp = new byte[buffSize];
        int size = 0;

        while ((size = bufin.read(temp)) != -1) {
            out.write(temp, 0, size);
        }

        bufin.close();

        byte[] content = out.toByteArray();

        return content;
    }

    public static void do_exec(String cmd) throws Exception {

        final Process p = Runtime.getRuntime().exec(cmd);
        final byte[] stderr = readBytes(p.getErrorStream());
        final byte[] stdout = readBytes(p.getInputStream());
        final int exitValue = p.waitFor();

        if (exitValue == 0) {
            throw new Exception("-----------------\r\n" + (new String(stdout)) + "-----------------\r\n");
        } else {
            throw new Exception("-----------------\r\n" + (new String(stderr)) + "-----------------\r\n");
        }

    }

    public static void main(final String[] args) throws Exception {
        do_exec("whoami");
    }
}