package com.kubadziworski.integration

import com.kubadziworski.compiler.Compiler
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by kuba on 11.05.16.
 */
class ShouldCompileAndRunTest extends Specification {

	@Unroll
	def "Should Compile and run"() {
		expect:
			// Compile
			Compiler.main("../EnkelExamples/$filename")

			// Run
			def className = filename
					.replaceAll(".*/", "")
					.replace(".enk", "")
			def classLoader = new URLClassLoader([new File(".").toURI().toURL()] as URL[])
			def enkelClass = classLoader.loadClass(className)
			def enkelMainMethod = enkelClass.getMethod("main",  [String[].class] as Class[])
			def emptyMainArgs = [[] as String[]] as Object[]
            def enkelInvocationResult = enkelMainMethod.invoke(null, emptyMainArgs)
			enkelInvocationResult == null // main returns void
		where:
			 filename | _
			 "HelloWorld.enk" | _
			 "Loops.enk" | _
			 "AllPrimitiveTypes.enk" | _
			 "DefaultParamTest.enk" | _
			 "Fields.enk" | _
			 "NamedParamsTest.enk" | _
			 "SumCalculator.enk" | _
			 "DefaultConstructor.enk" | _
			 "ParameterLessConstructor.enk" | _
			 "ConstructorWithParams.enk" | _
			 "EqualitySyntax.enk" | _
			 "Constructor/ConstructorWithParams.enk" | _
			 "Constructor/DefaultConstructor.enk" | _
			 "Constructor/ParameterLessConstructor.enk" | _
	}

}