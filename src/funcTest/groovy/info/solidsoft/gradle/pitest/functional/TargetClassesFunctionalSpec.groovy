package info.solidsoft.gradle.pitest.functional

import nebula.test.functional.ExecutionResult

class TargetClassesFunctionalSpec extends AbstractPitestFunctionalSpec {

    def "report error when no project group and no targetClasses parameter are defined"() {
        given:
            buildFile << """
                apply plugin: 'java'
                apply plugin: 'info.solidsoft.pitest'
            """.stripIndent()
        and:
            writeHelloWorld('gradle.pitest.test.hello')
        when:
            ExecutionResult result = runTasksWithFailure('pitest')
        then:
            assertStdOutOrStdErrContainsGivenText(result, "No value has been specified for property 'targetClasses'")
    }
}
