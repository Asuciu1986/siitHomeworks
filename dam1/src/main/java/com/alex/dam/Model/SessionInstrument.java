package com.alex.dam.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class SessionInstrument {

    @EmbeddedId
    private SessionInstrumentId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sessionId")
    private Session session;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("instrumentId")
    private Instrument instrument;

    //Constructor


    public SessionInstrument() {

    }

    public SessionInstrument(Session session, Instrument instrument) {
        this.session = session;
        this.instrument = instrument;
        this.id = new SessionInstrumentId(session.getId(),instrument.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionInstrument that = (SessionInstrument) o;
        return id.equals(that.id) &&
                session.equals(that.session) &&
                instrument.equals(that.instrument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, session, instrument);
    }
}
