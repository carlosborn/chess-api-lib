package org.ceborn.http.impl.responses;

import lombok.Getter;
import lombok.Setter;
import org.ceborn.builders.PGNFileRequestBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class PGNFileResponse extends AbstractResponse<PGNFileResponse> {

    @Setter
    private String path;
    private String data;

    @Getter
    private boolean savedFile;

    private PGNFileResponse() {
    }

    public static PGNFileRequestBuilder newBuilder() {
        return new PGNFileRequestBuilder(new PGNFileResponse());
    }

    public Optional<String> getData() {
        return Optional.ofNullable(this.data);
    }

    private void saveFile() {
        if (this.path == null) {
            this.savedFile = false;
            return;
        }

        File file = new File(this.path + this.getFileName());
        if (file.exists()) {
            this.savedFile = false;
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(this.getRawData());
            this.savedFile = true;
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
            this.savedFile = false;
        }
    }

    private String getFileName() {
        if (this.getHeaders().get("content-disposition").isEmpty()) {
            return "pgn_data.pgn";
        }

        String contentDisposition = this.getHeaders().get("content-disposition");
        return contentDisposition.split(";")[1]
                .split("=")[1]
                .replaceAll("\"", "");
    }

    @Override
    public PGNFileResponse load() {
        this.data = this.getRawData();
        this.saveFile();
        return this;
    }
}
