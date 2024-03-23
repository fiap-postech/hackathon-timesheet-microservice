package br.com.fiap.hackathon.time.sheet.pdf.report.generator.exception;

public class FailCreatingPDFException extends RuntimeException {
    public FailCreatingPDFException(Throwable cause) {
        super("some error occurred while was generating pdf", cause);
    }
}
