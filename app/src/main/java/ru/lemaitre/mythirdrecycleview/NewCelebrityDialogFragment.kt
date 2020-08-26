package ru.lemaitre.mythirdrecycleview

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import kotlin.random.Random

class NewCelebrityDialogFragment : DialogFragment() {
    interface NewCelebrityListener {
        fun createNewCelebrityListener(celebrity: Celebrity)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = activity?.layoutInflater
        val views = inflater?.inflate(R.layout.dialog_new_celebrity, null)
        return AlertDialog.Builder(requireActivity())
            .setView(views)
            .setPositiveButton("Создать", DialogInterface.OnClickListener { dialog, which ->
                val nameCelebritiy = views?.findViewById<EditText>(R.id.nameET)
                val salaryCount = views?.findViewById<EditText>(R.id.salaryET)
                val actor = views?.findViewById<RadioButton>(R.id.actorCBX)
                val sportsman = views?.findViewById<RadioButton>(R.id.sportsmanCBX)
                if (actor != null && sportsman != null && nameCelebritiy != null
                    && nameCelebritiy.text.toString().isNotEmpty()
                    && salaryCount != null && salaryCount.text.toString().isNotEmpty()
                    && salaryCount.text.toString().contains(Regex("\\d+"))
                ) {
                    if (!actor.isChecked && !sportsman.isChecked) {
                        Toast.makeText(
                            requireContext(),
                            "Выберите спортсмена или актера",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (actor.isChecked) {
                        val newActor = Celebrity.Actor(
                            id = Random.nextLong(),
                            name = nameCelebritiy.text.toString(),
                            salary = salaryCount.text.toString().toInt()
                        )
                        parentFragment.let { it as NewCelebrityListener }
                            .createNewCelebrityListener(newActor)
                    } else if (sportsman.isChecked) {
                        val newSportsman = Celebrity.Sportsman(
                            id = Random.nextLong(),
                            name = nameCelebritiy.text.toString(),
                            salary = salaryCount.text.toString().toInt()
                        )
                        parentFragment.let { it as NewCelebrityListener }
                            .createNewCelebrityListener(newSportsman)
                    }
                } else {
                    Toast.makeText(
                        requireContext(), "Некорректно введены данные", Toast.LENGTH_SHORT
                    ).show()
                }
            })
            .setNegativeButton(
                "Отмена",
                DialogInterface.OnClickListener { dialog, which -> dismiss() })
            .create()
    }
}