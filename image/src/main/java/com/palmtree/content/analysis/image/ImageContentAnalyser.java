package com.palmtree.content.analysis.image;

import com.google.cloud.vision.v1.*;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.protobuf.ByteString;
import org.apache.log4j.Logger;
import javax.validation.constraints.Max;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Created by kaarthikraaj on 10/8/17.
 **/

public class ImageContentAnalyser {

    private static Logger logger = Logger.getLogger(ImageContentAnalyser.class.getName());

    public static void main(String args[]) {
        ImageContentAnalyser analyser = new ImageContentAnalyser();
        System.out.println(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
        // System.out.println(analyser.isImageSafe("https://www.dailydot.com/wp-content/uploads/6c855233625ee8c7985a841c4bd068dd5e1.jpg/91/"));
        // System.out.println(analyser.isValidImage("https://i.pinimg.com/736x/a1/7c/69/a17c694d0f8f25774847f9224529cb8f.jpg"));
        // System.out.println(analyser.detectLogos("http://www.carlogos.org/logo/Audi-logo-1999-1920x1080.png"));
        // System.out.println(analyser.detectLandmarks("https://upload.wikimedia.org/wikipedia/commons/c/c8/Taj_Mahal_in_March_2004.jpg"));
        // System.out.println(analyser.detectTexts("http://www.gsproducts.co.uk/wordpress/wp-content/uploads/2015/04/Boat-name-Mariah.jpg"));

      //  HashMap smallRecthashMap = analyser.DocumentExtractionTemplate("http://www.k-billing.com/example_invoices/professionalblue_example.png");
       // analyser.generate_Template("http://www.k-billing.com/example_invoices/professionalblue_example.png" , smallRecthashMap);
        HashMap<String,String> input_hashmap = new HashMap<String, String>();

        input_hashmap.put("Branch","IT");
        input_hashmap.put("Name","Hamsa");
  // System.out.println(analyser.big("https://00e9e64bacfe67a36b6c6a06c1b094600c8856eda83377c12c-apidata.googleusercontent.com/download/storage/v1/b/palmtree-image-02.appspot.com/o/jjj.jpg?qk=AD5uMEtpd7yR-B9a4w9YrY77t3HB7E1GpgCE4py0nH917WkSY6KlXVS-0JlE_uKhclpEz4s176QSdIaHVX1CJYLNJJJ-eDWYrSDi-bm0imI6D8u0oSNbov6QheBecwTqU1hFrDrxCJ306n4a1GJoE-2V4wAHvGeV_kVELigsBJ73tAmWsfcGled2-8V3CS6BHRkm7fv3yZB73Al-E5EhUcSTv8igh0bZMI1hlFW0Lh-flbqTsUojdo5616OMUsU0tLjZ35Qr7II-iG_mgYoRwtCvBkDTbi_4PGW7TFAImwVidStP90qgLzi9rNHQYFVpXyq3zf7LTXCZQHVVDWmShAmrB4gG7xSJ8To6Ms3FKf4i0fDei9yHC9xwjn6Kh8D06wCBLzg4BmH_xUsR8p8vYkx4YSvg0oAcKOZqSzvpK-E_DWixKI2iWGDB-4MXaIXQp4PwEQiYzIV6FWq1frfd8VbKZDrBZEdl6RRsBRplel1ELG6hb09RDz3ntsyXroHbPZkDGc6KLYsiOFfwrg-SCfT4A8YAVMJdzcysl76gzKgBN9DCRh755ZxnPzfcYZAmuHZOab8f0RE77wnXVOFTyFdY7_nRI2zSnaSk42zsD2ISsNCrY1EyXTX1pP_ufxh5TdcskJArVgJeUpm4RQ9Ogdjokf7o4hFmVMuVOzUINw2L2of16QzDobZtVELtUt5n1ELDjPJmkOxlrumtdUu-lcg6meoKCAaZwJLwFZ2vcOZTgCtsjCmUeVk8ZlvzSl0AznGo8KinPcRE", input_hashmap));

    System.out.println(analyser.documentExtraction("https://00e9e64bac0f52aa6f241eca5e262ac4bf10fb7b859341f80b-apidata.googleusercontent.com/download/storage/v1/b/palmtree-image-02.appspot.com/o/jjj.jpg?qk=AD5uMEsKo57JgyT47sd_DsKej3pet0mUmzGpDru14Qg4b6FGtf4RGL8SL0IvyflHP-CUn76JXnq0LdA0oTP3XKUoGC2tkK9IzUVp3hL_Ld82qRwnqVGMHt7rXefoIg_shdWKgsYJj6NRaEggUMITrZYLuBmfQvU5mDhcmoG-MNCTCQzjbqDmebAHh8JaNFP1csWnsnLeUKiZkqMn57PgwAT80lwoa9ihzCcLVWs7PGjOWxxxDnmTAyB_oIjrAWgxfRRTnZNSslC4Bl9hYscAKgc3mggBkDNFCG27uchw6kELU8ReZtIOCPAwgxzdhgddooAMdFyS6h0oS9VkEoVuXxBI9MuIwy4E3R4Crp2ui8-SW9NnvKB1QOv0FH3waiqNKOAKc6MEwkqkuOmJ-FXRdqKBPgeprAaOsfE0QGqdkTvc0wj4x59LzjrmkMq8URGHRYVz9RCLyMRHNOxqgJbP2_aTmyYf2Wvv_eqnXENLfR9TyHRXfxPS-7IDy60nCR_bC0SVRoxw_1_rolwDpKajyQXJu57dS080CI7P0CZK0BeC05ft_kcvJo5SVnGd6dHGSD2Dllb1nm_msJGlDQ5ItHhDgvDPlenSuDRmAk7PsHFCyvQI1dKcr_ZEgKT0pp0POBP-jM6i9E1y-fk6qAHi3EspQTjUDvwc1otiUcagyFMQj8k13BrKUIEahfVh2cbNpQKioAD4MRYXX5iRKk4qItZ_YpcOZjwcYlk8Aq2wxwZ7IT_5i7urFAZ7vElE7q585wkPxwswTT_P", input_hashmap));

    }
  /*  public boolean big(String imageURI , HashMap<String,String> input)
    {

        float left_Top_X_Pos=0, left_Top_Y_Pos=0,
                right_Top_X_Pos=0,right_Top_Y_Pos=0,
                right_Bottom_X_Pos=0,right_Bottom_Y_Pos=0,
                left_Bottom_X_Pos=0,left_Bottom_Y_Pos=0;
        String str = "";
        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.LABEL_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.TEXT_DETECTION).build())
                    .build();
            imageReqsList.add(imageReq);
            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            List<String> Description = new ArrayList<String>();
            List<String> k1 = new ArrayList<String>();
            List<String> v1 = new ArrayList<String>();

            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses) {
                for (EntityAnnotation entityAnnotation : annotateImageResponse.getTextAnnotationsList()) {
                    Description.add(entityAnnotation.getDescription());

                  }
                System.out.println(Description);


            for (Map.Entry<String, String> entry: input.entrySet())
            {       String key = entry.getKey();
                     String value = entry.getValue();
                    k1.add(key);
                    v1.add(value);

            }

                for(int i=0;i<Description.size();i++)
                {
                    for(int j=0; j<k1.size();j++)
                {             //    System.out.println(k1.get(j));
               if(Description.equals(k1))
                {
                    System.out.println(v1);
               }
                }
                }
            }



        }       catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }
        return true;
    }
              */


    public boolean documentExtraction(String imageURI, HashMap<String, String> input_hashmap) {
        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.LABEL_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.TEXT_DETECTION).build())
                    .build();
            imageReqsList.add(imageReq);
            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            List<String> Description = new ArrayList<String>();
            List<List<Vertex>> vertex = new ArrayList<List<Vertex>>();
            List<Vertex> polygon = new ArrayList<Vertex>();
          HashMap<String,TextFieldArea> textPositionHM = new HashMap<String, TextFieldArea>();
     //       HashMap<String,String> hm1 = new HashMap<String, String>();
            String text = "";

            float left_Top_X_Pos = 0;               float right_Top_X_Pos = 0;
            float left_Bottom_X_Pos = 0;              float right_Bottom_X_Pos = 0;
            float left_Top_Y_Pos = 0;                    float right_Top_Y_Pos = 0;
            float left_Bottom_Y_Pos = 0;                  float right_Bottom_Y_Pos = 0;


            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses) {
                for (EntityAnnotation poly : annotateImageResponse.getTextAnnotationsList()) {
                    Description.add(poly.getDescription());
                    vertex.add(poly.getBoundingPoly().getVerticesList());   }  }

            for (int i = 1; i < vertex.size(); i++) {
                text = Description.get(i);
                polygon = vertex.get(i);

                Vertex First_co_ordinate = polygon.get(0);
                Vertex Second_co_ordinate = polygon.get(1);
                Vertex Third_co_ordinate = polygon.get(2);
                Vertex Forth_co_ordinate = polygon.get(3);

                left_Top_X_Pos = First_co_ordinate.getX();
                left_Top_Y_Pos = First_co_ordinate.getY();
                right_Top_X_Pos = Second_co_ordinate.getX();
                right_Top_Y_Pos = Second_co_ordinate.getY();
                right_Bottom_X_Pos = Third_co_ordinate.getX();
                right_Bottom_Y_Pos = Third_co_ordinate.getY();
                left_Bottom_X_Pos = Forth_co_ordinate.getX();
                left_Bottom_Y_Pos = Forth_co_ordinate.getY();
//System.out.println(text);
                TextFieldArea textFieldArea = new TextFieldArea(left_Bottom_X_Pos, left_Bottom_Y_Pos,
                        right_Bottom_X_Pos, right_Bottom_Y_Pos, right_Top_X_Pos, right_Top_Y_Pos, left_Top_X_Pos, left_Top_Y_Pos);
                  textPositionHM.put(text,textFieldArea);
      //        hm1.put(text, text);
            }

          Set<String> inputHMset = input_hashmap.keySet();
            Set<String> textPositionset = textPositionHM.keySet();
            Iterator<String> inputHMiter =inputHMset.iterator();
            Iterator<String> textPositioniter =textPositionset.iterator();
            String val1="";

            while (inputHMiter.hasNext())
            {   val1=inputHMiter.next();
               // System.out.println(v);
               textPositioniter=textPositionset.iterator();
                  while (textPositioniter.hasNext())
                  {
                  String val2 = textPositioniter.next();
               //  System.out.println(v2);
                 if(input_hashmap.get(val1).equals(val2))
             {
    System.out.println(val1 +"---------------"+ val2);


          }    }     }

            TextFieldArea textFieldArea_bigRect = new TextFieldArea(left_Top_X_Pos,left_Top_Y_Pos,right_Top_X_Pos,
                    right_Top_Y_Pos,right_Bottom_X_Pos,right_Bottom_Y_Pos,
                    left_Bottom_X_Pos,left_Bottom_Y_Pos);

            System.out.println(extractTextValueForLabel(textFieldArea_bigRect , textPositionHM));




  //       System.out.println(input_hashmap.);
// System.out.println("equals: " + input_hashmap.equals(hm1));


        } catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }
        return true;
    }


































    public boolean isImageSafe(String imageURI) {
        boolean isSafe = true;

        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.SAFE_SEARCH_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.WEB_DETECTION).build()).build();
            imageReqsList.add(imageReq);

            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses) {


                SafeSearchAnnotation safeAnnotation = annotateImageResponse.getSafeSearchAnnotation();
                if (safeAnnotation.getViolence().getNumber() > 1
                        || safeAnnotation.getAdult().getNumber() > 3) {
                    return false;
                }

                WebDetection webDetection = annotateImageResponse.getWebDetection();
                for (WebDetection.WebEntity webEntity : webDetection.getWebEntitiesList()) {
                    if (webEntity.getDescription().equalsIgnoreCase("Weapon")
                            || webEntity.getDescription().equalsIgnoreCase("cigarette")
                            || webEntity.getDescription().equalsIgnoreCase("Alcohol")
                            || webEntity.getDescription().equalsIgnoreCase("Alcoholic drink")
                            || webEntity.getDescription().equalsIgnoreCase("Tobacco")
                            || webEntity.getDescription().equalsIgnoreCase("Knife")
                            || webEntity.getDescription().equalsIgnoreCase("Ground fighting")
                            || webEntity.getDescription().equalsIgnoreCase("Shooting")
                            || webEntity.getDescription().equalsIgnoreCase("Blood")
                            || webEntity.getDescription().equalsIgnoreCase("Daemon's Souls")
                            || webEntity.getDescription().equalsIgnoreCase("Stabbing"))

                        return false;
                }
            }
        } catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }

        return isSafe;
    }

    public boolean isValidImage(String imageURI) {
        boolean isValid = true;

        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.LABEL_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.SAFE_SEARCH_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.FACE_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.WEB_DETECTION).build())
                    .build();
            imageReqsList.add(imageReq);

            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses) {

                List<EntityAnnotation> labelAnnotations = annotateImageResponse.getLabelAnnotationsList();
                WebDetection wb = annotateImageResponse.getWebDetection();
                List<WebDetection.WebEntity> wb1 = wb.getWebEntitiesList();
                boolean hasError = annotateImageResponse.hasError();
                System.out.println(annotateImageResponse.getError().getMessage());


                for (EntityAnnotation entityAnnotation : labelAnnotations) {
                    if (entityAnnotation.getDescription().equalsIgnoreCase("Headgear")
                            ||entityAnnotation.getDescription().equalsIgnoreCase("Sunglasses")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Mask")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Helmet")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Turban")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Fedora")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Mammal")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Animal")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Cartoon")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Tattoo")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Actor")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Actress")) {

                        return false;
                    }
                }

                for (WebDetection.WebEntity webEntity : wb.getWebEntitiesList()) {
                    if (webEntity.getDescription().equalsIgnoreCase("Optics")
                            || webEntity.getDescription().equalsIgnoreCase("Visual perception"))
                    {

                        return true;
                    }
                    else if (webEntity.getDescription().equalsIgnoreCase("Silhouette")
                            || webEntity.getDescription().equalsIgnoreCase("Tattoo")
                            || webEntity.getDescription().equalsIgnoreCase("Cartoon")
                            || webEntity.getDescription().equalsIgnoreCase("Mask")
                            || webEntity.getDescription().equalsIgnoreCase("Headwear")
                            || webEntity.getDescription().equalsIgnoreCase("Headscarf")
                            || webEntity.getDescription().equalsIgnoreCase("Animal")
                            || webEntity.getDescription().equalsIgnoreCase("Mammal")
                            || webEntity.getDescription().equalsIgnoreCase("Actress")
                            || webEntity.getDescription().equalsIgnoreCase("Actor")) {

                        return false;
                    }
                }
            }
        } catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }

        return isValid;
    }

    public List<String> detectLandmarks(String imageURI) {
        List<String> detectedLandMarks = new ArrayList<String>();

        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            System.out.println(image.getSource().getImageUri());

            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.LABEL_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.LANDMARK_DETECTION).build())
                    .build();
            imageReqsList.add(imageReq);

            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses) {
                for (EntityAnnotation landmark : annotateImageResponse.getLandmarkAnnotationsList()) {
                    detectedLandMarks.add(landmark.getDescription());
                }
            }

        } catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }

        return detectedLandMarks;
    }

    public List<String> detectLandmark(byte[] imageContent) {
        List<String> detectedLandMarks = new ArrayList<String>();

        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setContent(ByteString.copyFrom(imageContent)).build();

            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.LABEL_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.LOGO_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.LANDMARK_DETECTION).build())
                    .build();
            imageReqsList.add(imageReq);

            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses) {
                for (EntityAnnotation landmark : annotateImageResponse.getLandmarkAnnotationsList()) {
                    detectedLandMarks.add(landmark.getDescription());
                }
            }
        } catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());

        }

        return detectedLandMarks;
    }

    public List<String> detectLogos(String imageURI) {
        List<String> logosDetected = new ArrayList<String>();

        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.LOGO_DETECTION).build())
                    .build();
            imageReqsList.add(imageReq);

            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses) {
                for (EntityAnnotation logo : annotateImageResponse.getLogoAnnotationsList()) {
                    logosDetected.add(logo.getDescription());
                }
            }
        } catch (Exception exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }
        return logosDetected;
    }


    /* Document Generating API */
    public HashMap DocumentExtractionTemplate(String imageURI) {
        HashMap<String, TextFieldArea> smallRecthashMap = null;
        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.LABEL_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.TEXT_DETECTION).build())
                    .build();
            imageReqsList.add(imageReq);
            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            List<String> Description = new ArrayList<String>();
            List<List<Vertex>> vertex = new ArrayList<List<Vertex>>();
            List<Vertex> polygon = new ArrayList<Vertex>();
            String text = "";
            float left_Top_X_Pos = 0;
            float right_Top_X_Pos = 0;
            float left_Bottom_X_Pos = 0;
            float right_Bottom_X_Pos = 0;
            float left_Top_Y_Pos = 0;
            float right_Top_Y_Pos = 0;
            float left_Bottom_Y_Pos = 0;
            float right_Bottom_Y_Pos = 0;

            smallRecthashMap = new HashMap<String, TextFieldArea>();

        } catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }
        return smallRecthashMap;
    }

    private boolean generate_Template(String imageURI,HashMap<String, TextFieldArea> bigRecthashMap)
    {   HashMap<String,TextFieldArea> bigRecthashMapNew = new HashMap<String, TextFieldArea>();

        float left_Top_X_Pos=0, left_Top_Y_Pos=0,
                right_Top_X_Pos=0,right_Top_Y_Pos=0,
                right_Bottom_X_Pos=0,right_Bottom_Y_Pos=0,
                left_Bottom_X_Pos=0,left_Bottom_Y_Pos=0;
        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.LABEL_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.TEXT_DETECTION).build())
                    .build();
            imageReqsList.add(imageReq);
            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);



        }       catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }
        return true;
    }


    // Method For Comparing Rectangle
    private String extractTextValueForLabel(TextFieldArea bigRect , HashMap<String, TextFieldArea> smallRect)
    {
        Iterator it = smallRect.entrySet().iterator();
        StringBuilder builder = new StringBuilder();
        String text = "";

        while (it.hasNext())
        {

            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            TextFieldArea value = (TextFieldArea) entry.getValue();

            if ((value.left_Top_X_Pos >=  bigRect.left_Top_X_Pos
                    && value.left_Top_Y_Pos >= bigRect.left_Top_Y_Pos)

                    && (value.right_Bottom_X_Pos <= bigRect.right_Bottom_X_Pos
                    && value.right_Bottom_Y_Pos <= bigRect.right_Bottom_Y_Pos))
            {
                builder.append(key);
                builder.append(" ");
            }
        }
        text = builder.toString();
        return text;
    }

 /*   private String extractTextValueForLabel(String imageURI , HashMap<String, TextFieldArea> docTextsCoordinates) {
        String text = "";
        float left_Top_X_Pos;
        float left_Top_Y_Pos;
        float right_Top_X_Pos;
        float right_Top_Y_Pos;
        float right_Bottom_X_Pos;
        float right_Bottom_Y_Pos;
        float left_Bottom_X_Pos;
        float left_Bottom_Y_Pos;
        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.LABEL_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.TEXT_DETECTION).build())
                    .build();
            imageReqsList.add(imageReq);
            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            List<String> Description = new ArrayList<String>();
            List<List<Vertex>> vertex = new ArrayList<List<Vertex>>();
            List<Vertex> polygon = new ArrayList<Vertex>();


            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses) {
                for (EntityAnnotation poly : annotateImageResponse.getTextAnnotationsList()) {
                    // System.out.println(poly.getDescription() + poly.getBoundingPoly().getVerticesList());
                    Description.add(poly.getDescription());
                    vertex.add(poly.getBoundingPoly().getVerticesList());
                }
            }
            for (int i = 0; i < vertex.size(); i++) {
                text = Description.get(i);

                polygon = vertex.get(i);


                Vertex First_co_ordinate = polygon.get(0);
                Vertex Second_co_ordinate = polygon.get(1);
                Vertex Third_co_ordinate = polygon.get(2);
                Vertex Forth_co_ordinate = polygon.get(3);

                left_Top_X_Pos = First_co_ordinate.getX();
                left_Top_Y_Pos = First_co_ordinate.getY();
                right_Top_X_Pos = Second_co_ordinate.getX();
                right_Top_Y_Pos = Second_co_ordinate.getY();
                right_Bottom_X_Pos = Third_co_ordinate.getX();
                right_Bottom_Y_Pos = Third_co_ordinate.getY();
                left_Bottom_X_Pos = Forth_co_ordinate.getX();
                left_Bottom_Y_Pos = Forth_co_ordinate.getY();



        TextFieldArea valueRectCoordinates = new TextFieldArea(text, left_Bottom_X_Pos, left_Bottom_Y_Pos, right_Bottom_X_Pos, right_Bottom_Y_Pos, right_Top_X_Pos, right_Top_Y_Pos, left_Top_X_Pos, left_Top_Y_Pos);

                // System.out.println(text);

            //  Set<Map.Entry<String,TextFieldArea>> entrySet = hashMap.entrySet();

            Iterator it = docTextsCoordinates.entrySet().iterator();
            StringBuilder builder = new StringBuilder();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String key = (String) entry.getKey();
                TextFieldArea value = (TextFieldArea) entry.getValue();

                if ((value.left_Top_X_Pos >= valueRectCoordinates.left_Top_X_Pos
                        && value.left_Top_Y_Pos >= valueRectCoordinates.left_Top_Y_Pos)

                        && (value.right_Bottom_X_Pos <= valueRectCoordinates.right_Bottom_X_Pos
                        && value.right_Bottom_Y_Pos <= valueRectCoordinates.right_Bottom_Y_Pos))
                {
                    builder.append(key);
                    builder.append(" ");
                }
            }
            text = builder.toString();
            }
        } catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }
        return text;
    }   */

}


class TextFieldArea{
    float left_Top_X_Pos,right_Top_X_Pos,left_Bottom_X_Pos, right_Bottom_X_Pos,
            left_Top_Y_Pos,right_Top_Y_Pos,left_Bottom_Y_Pos, right_Bottom_Y_Pos;
    public TextFieldArea(float left_Top_X_Pos,float left_Top_Y_Pos,float  right_Top_X_Pos,
                         float right_Top_Y_Pos,float right_Bottom_X_Pos,float right_Bottom_Y_Pos,
                         float left_Bottom_X_Pos, float left_Bottom_Y_Pos)
    {
        this.left_Top_X_Pos = left_Top_X_Pos;
        this.left_Top_Y_Pos = left_Top_Y_Pos;
        this.right_Top_X_Pos = right_Top_X_Pos;
        this.right_Top_Y_Pos = right_Top_Y_Pos;
        this.right_Bottom_X_Pos = right_Bottom_X_Pos;
        this.right_Bottom_Y_Pos = right_Bottom_Y_Pos;
        this.left_Bottom_X_Pos = left_Bottom_X_Pos;
        this.left_Bottom_Y_Pos = left_Bottom_Y_Pos;  }}