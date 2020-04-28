package com.openclassrooms.entrevoisins.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;
import java.util.Random;

import static com.openclassrooms.entrevoisins.service.DummyNeighbourGenerator.NEW_NEIGHBOUR;

/**
 * Model object representing a Neighbour
 */
public class Neighbour implements Parcelable {

    /**
     * Identifier
     */
    private Integer id;

    /**
     * Full name
     */
    private String name;

    /**
     * Avatar
     */
    private String avatarUrl;

    /**
     * Favorite Status
     */
    private boolean favoriteStatus;

    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param avatarUrl
     * @param favoriteStatus
     */
    public Neighbour(Integer id, String name, String avatarUrl, boolean favoriteStatus) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.favoriteStatus = favoriteStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public boolean isFavoriteStatus() {
        return favoriteStatus;
    }

    public void setFavoriteStatus(boolean favoriteStatus) {
        this.favoriteStatus = favoriteStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = (Neighbour) o;
        return Objects.equals(id, neighbour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Neighbour addNewNeighbour(){
        return NEW_NEIGHBOUR.get(new Random().nextInt(NEW_NEIGHBOUR.size()));
    }

    public static final Parcelable.Creator<Neighbour> CREATOR = new Parcelable.Creator<Neighbour>() {
        public Neighbour createFromParcel(Parcel in) {
            return new Neighbour(in);
        }

        public Neighbour[] newArray(int size) {
            return new Neighbour[size];
        }
    };

    private Neighbour(Parcel in) {
        id = in.readInt();
        name = in.readString();
        avatarUrl = in.readString();
        favoriteStatus = in.readByte() != 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(avatarUrl);
        dest.writeByte((byte) (favoriteStatus ? 1 : 0));
    }
}
