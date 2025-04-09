gradlew = './gradlew'
expected_ref = '$EXPECTED_REF'
if os.name == 'nt':
  gradlew = 'gradlew.bat'
  expected_ref = '%EXPECTED_REF%'

custom_build(
    ref = 'order-service',
    command = gradlew + ' bootBuildImage --imageName ' + expected_ref,
    deps = ['build.gradle', 'src']
)

k8s_yaml(kustomize('k8s'))

k8s_resource('order-service', port_forwards=['9002'])
