package mimex;

public abstract class ClassMetadataExtractor extends MetadataExtractor {
    private final Class<?> dataClass;

    public ClassMetadataExtractor(Class<?> dataClass) {
        this.dataClass = dataClass;
    }

    @Override
    protected void writeToFile(String file) {
        super.writeToFile(file);
        MindustryMetadataExtractor.registerClass(dataClass.getSimpleName(), getFileName(file));
    }
}
