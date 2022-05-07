package pp.developer.ejercicio05_navigationrepaso

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlin.random.Random

public class NumeroRandom(val appContext: Context,val workerParams: WorkerParameters):
    Worker(appContext,workerParams) {
    private var seeker: Int = Random.nextInt()
    public fun getAleatorio():Int{
        return  Random.nextInt()
    }

    override fun doWork(): Result {
        for(i in 1..5) {
            Log.d("WorkRand", "Numero: ${getAleatorio()}")
            Thread.sleep(1000)
        }
        return Result.success()
    }

}