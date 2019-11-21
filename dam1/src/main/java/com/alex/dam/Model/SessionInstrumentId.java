package com.alex.dam.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SessionInstrumentId implements Serializable {

    @Column(name="session_id")
    private Long sessionId;

    @Column(name="interval_id")
    private Long instrumentId;

    public SessionInstrumentId() {
    }

    public SessionInstrumentId(Long sessionId, Long instrumentId) {
        this.sessionId = sessionId;
        this.instrumentId = instrumentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionInstrumentId that = (SessionInstrumentId) o;
        return sessionId.equals(that.sessionId) &&
                instrumentId.equals(that.instrumentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, instrumentId);
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Long getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Long instrumentId) {
        this.instrumentId = instrumentId;
    }
}
