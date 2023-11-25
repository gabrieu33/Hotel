package ifam.edu.br.pdm.listacompras.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ifam.hotelll.Data.acessorios.ItemEntity

@Database(entities = [ItemEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ItemsDatabase : RoomDatabase() {
    abstract fun itemsDAO(): ItemDAO
}