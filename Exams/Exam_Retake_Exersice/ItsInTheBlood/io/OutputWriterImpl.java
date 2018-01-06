package ItsInTheBlood.io;


import ItsInTheBlood.interfaces.OutputWriter;

public class OutputWriterImpl implements OutputWriter {

    @Override
    public void printLine(String lineForPrint) {
        System.out.println(lineForPrint);
    }
}
