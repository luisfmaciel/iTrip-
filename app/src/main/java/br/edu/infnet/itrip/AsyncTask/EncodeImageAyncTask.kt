package br.edu.infnet.itrip.AsyncTask

import android.graphics.Bitmap
import android.os.AsyncTask
import android.util.Base64
import br.edu.infnet.itrip.ENCODE_IMAGE
import java.io.ByteArrayOutputStream

class EncodeImageAyncTask(var mBitmap: Bitmap)
    : AsyncTask<Void, Unit, String>()
{
    override fun doInBackground(vararg void: Void?): String? {
        val baos = ByteArrayOutputStream()
        mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val b: ByteArray = baos.toByteArray()
        return Base64.encodeToString(b, Base64.DEFAULT)
    }

    override fun onPostExecute(result: String?) {
        ENCODE_IMAGE = result!!

    }

}