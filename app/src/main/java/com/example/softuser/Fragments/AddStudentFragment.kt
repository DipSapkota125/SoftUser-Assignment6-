 package com.example.softuser.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.softuser.R
import com.example.softuser.StudentData
import com.example.softuser.model.Student


class AddStudentFragment : Fragment() {

    private lateinit var etfullname: EditText
    private lateinit var etage: EditText
    private lateinit var radiogroup : RadioGroup
    private lateinit var rdmale: RadioButton
    private lateinit var rdfemale: RadioButton
    private lateinit var rdothers: RadioButton
    private lateinit var etaddress: EditText
    private lateinit var etimage: EditText
    private lateinit var btnsave: Button

    var newStudent=ArrayList<Student>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_student, container, false)

        etfullname = view.findViewById(R.id.etfullname)
        etage = view.findViewById(R.id.etage)
        radiogroup = view.findViewById(R.id.radiogroup)
        rdmale = view.findViewById(R.id.rdmale)
        rdfemale = view.findViewById(R.id.rdfemale)
        rdothers = view.findViewById(R.id.rdothers)
        etaddress = view.findViewById(R.id.etaddress)
        etimage = view.findViewById(R.id.etimage)

        btnsave = view.findViewById(R.id.btnsave)

        btnsave.setOnClickListener {
            var name = etfullname.text.toString();
            var age = 0;
            try{
                age = etage.text.toString().toInt();
            }catch (e:Exception){
                e.printStackTrace();
                age = 0;
            }
            var gender=radiogroup.checkedRadioButtonId.toString()
            if(radiogroup.checkedRadioButtonId!=1){
                if(rdmale.isChecked){
                    gender="Male"
                }else if (rdfemale.isChecked){
                    gender="Female"
                }else if (rdothers.isChecked){
                    gender="other"
                }

            }


            var address = etaddress.text.toString();
            var image = etimage.text.toString();
            var studentdata = Student(id, name, age, gender, address, image)

            newStudent.add(studentdata);
            var bundle = Bundle()
            bundle.putString("data","yourdata");
            var homeFragment = HomeFragment();
            homeFragment.arguments = bundle
            StudentData.get().List().add(studentdata);

            etfullname.setText("")
            etage.setText("")
            rdmale.isChecked=false
            rdfemale.isChecked=false
            rdothers.isChecked=false
            etaddress.setText("")
            etimage.setText("")

        }
        return view
    }

}