package com.example.rickandmorti.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.rickandmorti.databinding.ActivityCharacterDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsActivity : AppCompatActivity() {

    private val binding by lazy { ActivityCharacterDetailsBinding.inflate(layoutInflater) }
    private val viewModel: CharacterDetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val characterId = intent.getIntExtra("characterId", -1)
        if (characterId == -1) {
            Log.e("ololo", "Invalid characterId")
            finish()
            return
        }

        viewModel.loadCharacter(characterId)


        viewModel.character.observe(this) { character ->
            if (character != null) {
                binding.apply {
                    tvName.text = character.name
                    specialsAlive.text = "${character.status} - ${character.species}"
                    tvType.text =  if (character.type?.isNotEmpty() == true){
                        "Type - ${character.type}"
                    } else {
                        "Type - ??"
                    }
                    tvGender.text = "Gender - ${character.gender}"
                    tvLocation.text = "Location - ${character.location?.name}"

                    Glide.with(ivImg.context)
                        .load(character.image)
                        .into(ivImg)
                }
            } else {
                Log.e("ololo", "Character is null")
            }
        }
    }
}