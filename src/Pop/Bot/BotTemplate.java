package Pop.Bot;

import Pop.Enums.TFClasses;

/**
 * Represents a single template for a bot
 */
public class BotTemplate {
    private TFClasses tfClass;
    public TFClasses getTfClass() { return tfClass; }
    public void setTfClass(TFClasses tfClass) { this.tfClass = tfClass; }

    private String templateName;
    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private boolean isGiant;
    public boolean getIsGiant() {
        return isGiant;
    }
    public void setIsGiant(boolean isGiant)
    {
        this.isGiant = isGiant;
    }

    private transient String classIcon;
    public String getClassIcon() {
        return classIcon;
    }
    public void setClassIcon(String classIcon) {
        if (classIcon == null || classIcon.trim().equals("")) {
            this.classIcon = tfClass.getStringForClassIcon();
        } else {
            this.classIcon = classIcon;
        }
    }

    /**
     * Default constructor
     */
    public BotTemplate() { }

    /**
     * Constructor
     */
    public BotTemplate(String templateName, TFClasses tfClass, String name, boolean isGiant) {
        this.templateName = templateName;
        this.tfClass = tfClass;
        this.name = name;
        this.isGiant = isGiant;
    }

    /**
     * Constructor
     */
    public BotTemplate(String templateName, TFClasses tfClass, String name, boolean isGiant, String classIcon) {
        this.templateName = templateName;
        this.tfClass = tfClass;
        this.name = name;
        this.isGiant = isGiant;
        setClassIcon(classIcon);
    }

    /**
     * Returns an instance of a sentry buster template
     */
    public static BotTemplate getSentryBusterTemplate() {
        return new BotTemplate("T_TFBot_SentryBuster", null, "Sentry Buster", false);
    }

    /**
     * Override the equals method since templates are compared
     * @param obj - the object to compare to
     * @return True if the objects are equal; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!BotTemplate.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final BotTemplate other = (BotTemplate) obj;

        return
            this.name.equals(other.name) &&
            this.templateName.equals(other.templateName) &&
            this.tfClass.getDisplayString().equals(other.tfClass.getDisplayString()) &&
            this.isGiant == other.isGiant;
    }

    /**
     * Override the hashCode method to ensure that equals works properly
     * @return The hashcode
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 53 * hash + (this.templateName != null ? this.templateName.hashCode() : 0);
        hash = 53 * hash + (this.tfClass != null ? this.tfClass.hashCode() : 0);
        hash = 53 * hash + (this.isGiant ? 1 : 0);
        return hash;
    }
}
