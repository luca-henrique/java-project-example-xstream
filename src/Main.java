import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.IntConverter;
import com.thoughtworks.xstream.converters.basic.StringConverter;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import model.Livro;

public class Main {

	public static void main(String args[]) {

		FileOutputStream fos = null;

		XStream xstream = new XStream(new StaxDriver()) {
			@Override
			protected void setupConverters() {
			}
		};
		xstream.registerConverter(new ReflectionConverter(xstream.getMapper(), xstream.getReflectionProvider()),
				XStream.PRIORITY_VERY_LOW);
		xstream.registerConverter(new IntConverter(), XStream.PRIORITY_NORMAL);
		xstream.registerConverter(new StringConverter(), XStream.PRIORITY_NORMAL);
		xstream.registerConverter(new CollectionConverter(xstream.getMapper()), XStream.PRIORITY_NORMAL);

		Livro livro = new Livro(2000, "Assim Falou Zaratustra", "123");

		String xml = xstream.toXML(livro);

		try {
			fos = new FileOutputStream("myfilename");
			fos.write(xml.getBytes("UTF-8"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
