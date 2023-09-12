package com.example.papewall.fragments

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs

class DownloadFragment : Fragment() {



    private lateinit var binding : FragmentDownloadBinding
    private val args : DownloadFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(R.transition.image_animation)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDownloadBinding.inflate(inflater, container, false)

        loadWall(args.imageData[0])
        bottomSheet()
        addCallBacks()
        return binding.root
    }

    private fun loadWall(url: String) {
        val blurHashAsDrawable = BlurHashDecoder.decode(args.imageData[1])
        Glide.with(this)
            .load(url)
            .centerCrop()
            .placeholder(blurHashAsDrawable?.toDrawable(this.resources))
            .error(blurHashAsDrawable)
            .into(binding.downloadImageView)

        binding.constraintDownload.background = BitmapDrawable(this.resources, blurHashAsDrawable)
    }
    private fun addCallBacks() {
        binding.backButton.setOnClickListener {v->
            Navigation.findNavController(v).popBackStack()
        }

    }

    private fun bottomSheet() {
        val bottomSheetFragment = BottomSheetFragment(args.imageData[0])
        binding.downloadButton.setOnClickListener {
            bottomSheetFragment.show(requireActivity().supportFragmentManager, "bottomSheetDialog")
        }

    }
}