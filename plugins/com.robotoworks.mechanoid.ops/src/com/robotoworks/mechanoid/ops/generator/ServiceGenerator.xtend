package com.robotoworks.mechanoid.ops.generator

import com.robotoworks.mechanoid.ops.opServiceModel.Model

import static extension com.robotoworks.mechanoid.text.Strings.*
import static extension com.robotoworks.mechanoid.ops.generator.Extensions.*;

class ServiceGenerator {
		def CharSequence generate(Model model) '''
			�var svc = model.service�
			/*
			 * Generated by Robotoworks Mechanoid
			 */
			package �model.packageName�;
			
			import com.robotoworks.mechanoid.ops.OperationProcessor;
			import com.robotoworks.mechanoid.ops.OperationService;
			import �model.packageName�.�svc.name.pascalize�Processor;
			
			public abstract class Abstract�svc.name.formatServiceName� extends OperationService {
				@Override
				protected OperationProcessor createProcessor() {
					return new �svc.name.pascalize�Processor(this);
				}
				
				public Abstract�svc.name.formatServiceName�(boolean enableLogging) {
					super(enableLogging);
				}
			}
			'''
			
		def CharSequence generateStub(Model model) '''
			�var svc = model.service�
			/*
			 * Generated by Robotoworks Mechanoid
			 */
			package �model.packageName�;
			
			import �model.packageName�.Abstract�svc.name.formatServiceName�;
			
			public class �svc.name.formatServiceName� extends Abstract�svc.name.formatServiceName� {
				public �svc.name.formatServiceName�() {
					super(false);
				}
			}
		'''
}