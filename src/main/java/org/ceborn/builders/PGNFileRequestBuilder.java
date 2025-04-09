package org.ceborn.builders;

import org.ceborn.http.impl.responses.PGNFileResponse;

public class PGNFileRequestBuilder extends AbstractBuilder<PGNFileResponse> {

    public PGNFileRequestBuilder(PGNFileResponse pgnFileResponse) {
        super(pgnFileResponse);
    }

    public AbstractBuilder<PGNFileResponse> setPath(String path) {
        this.getResponse().setPath(path);
        return this;
    }

    @Override
    public PGNFileResponse build() {
        return this.getResponse().load();
    }
}
