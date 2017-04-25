package fi.jamk.javaee.ogrecipes.app;

import java.io.IOException;
import java.lang.reflect.Field;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class IdOnlySerializer extends StdSerializer<Object> {
	 
	 
    public IdOnlySerializer() { 
        this(null); 
    } 
 
    public IdOnlySerializer(Class<Object> t) {
        super(t); 
    }
 
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider arg2) throws JsonGenerationException, IOException {
		Field field;
		try {
			field = value.getClass().getDeclaredField("id");
			field.setAccessible(true);
			Integer id = (Integer)field.get(value);
	        gen.writeNumber(id);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			gen.writeNumber(-1);
			e.printStackTrace();
		}
    }
}