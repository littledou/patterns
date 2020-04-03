package cn.readsense.aac.viewmodel

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import java.math.BigDecimal

class StockLiveData(symbol: String) : LiveData<BigDecimal>() {

    private val listener = { price: BigDecimal ->
        value = price
    }

    override fun onActive() {
        super.onActive()
    }

    override fun onInactive() {
        super.onInactive()
    }

    companion object {
        private lateinit var instance: StockLiveData

        @MainThread
        fun get(symbol: String): StockLiveData {
            instance = if (::instance.isInitialized) instance else StockLiveData(symbol)
            return instance
        }
    }
}