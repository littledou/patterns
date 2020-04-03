package cn.readsense.aac.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "frist_name") val fristName: String,
    @ColumnInfo(name = "last_name") val lastName: String
) {
    override fun toString(): String {
        return fristName
    }
}