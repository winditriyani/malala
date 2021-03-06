package com.example.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Model_Tempat_Wisata{
	
	private String idwisata;
	private String idkabupaten;
    private String nama_wisata;
    private String lokasi;
    private String foto;
    
   
  
    
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public String getNama_wisata() {
		return nama_wisata;
	}
	public void setNama_wisata(String nama_wisata) {
		this.nama_wisata = nama_wisata;
	}
	
	public String getIdkabupaten(){
		return idkabupaten;
	}
	public void setIdkabupaten (String idkabupaten) {
		this.idkabupaten = idkabupaten;
	}
	
	
	public String getIdwisata() {
		return idwisata;
	}
	public void setIdwisata(String idwisata) {
		this.idwisata = idwisata;
	}
	public String getLokasi() {
		return lokasi;
	}
	public void setLokasi (String lokasi) {
		this.lokasi = lokasi;
	}
	
	
	public static List<Model_Tempat_Wisata> parseFeed(String response) {

		try {
			JSONObject object = new JSONObject(response);
			return parseFeed (object);

		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Model_Tempat_Wisata> parseFeed(JSONObject obj) {
        try {
           
            JSONArray arrayObj = obj.getJSONArray("data");

            List<Model_Tempat_Wisata> wisataList = new ArrayList<Model_Tempat_Wisata>();

            for (int i = 0; i < arrayObj.length(); i++) {
                JSONObject wisataObj = arrayObj.getJSONObject(i);
                Model_Tempat_Wisata wisata = new Model_Tempat_Wisata();
                
                wisata.setIdwisata(wisataObj.getString("id_wisata"));
                wisata.setIdkabupaten(wisataObj.getString("idk"));
                wisata.setNama_wisata(wisataObj.getString("nama_tempat_wisata"));
                wisata.setLokasi(wisataObj.getString("lokasi"));
                wisata.setFoto(wisataObj.getString("foto_tempat_wisata"));
              
               

                wisataList.add(wisata);
            }
            return wisataList;
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }

}