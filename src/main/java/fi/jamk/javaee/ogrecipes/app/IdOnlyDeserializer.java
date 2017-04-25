package fi.jamk.javaee.ogrecipes.app;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.persistence.EntityManager;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class IdOnlyDeserializer<T> extends StdDeserializer<T> {

    final Class<T> typeClass;
	 
    public IdOnlyDeserializer(Class<T> tclass) {
        super (tclass);
        this.typeClass = tclass;
    } 
    public IdOnlyDeserializer() {
        super (Object.class);
        this.typeClass = null;
    } 
 

	@Override
	public T deserialize(JsonParser jp, DeserializationContext arg1) throws IOException, JsonProcessingException
	{
        try
        {
        	int id = jp.getIntValue();
        	EntityManager em = RecipeAppContext.createEntityManager();

 			Object obj = em.getReference(typeClass, id);
 	        em.close();
 	        
 	        if (typeClass.isAssignableFrom(obj.getClass()))
 	        	return (T) obj;
 	        return null;

        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        return null;
	}
}

