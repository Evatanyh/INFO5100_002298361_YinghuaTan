+-----------------------------------------+
|              Application                |
+-----------------------------------------+
| - stage: Stage                         |
| - controller: ImageController          |
+-----------------------------------------+
| + start(stage: Stage): void            |
+-----------------------------------------+

                |
                V

+-----------------------------------------+
|            ImageController              |
+-----------------------------------------+
| - imageView: ImageView                 |
| - infoTextLabel: Label                 |
| - formatComboBox: ComboBox<String>    |
| - selectedImageFile: File              |
| - convertedImageFile: File             |
| - imageProperties: Map<String, String> |
+-----------------------------------------+
| + initialize(): void                   |
| + selectImage(): void                  |
| + convertImage(): void                 |
| + saveImage(): void                    |
| - convert(inputFile: File, outputFile: File, outputFormat: String): void|
+-----------------------------------------+

                |
                V

+-----------------------------------------+
|              ImageUtils                 |
+-----------------------------------------+
| - getImageProperties(image: File): Map<String, String> |
| - convertImage(inputFile: File, outputFile: File, outputFormat: String): void |
+-----------------------------------------+

