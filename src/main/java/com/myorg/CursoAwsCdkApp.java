package com.myorg;

import software.amazon.awscdk.App;

public class CursoAwsCdkApp {
    public static void main(final String[] args) {
        App app = new App();

        VpcStack vpcStack = new VpcStack(app, "Vpc");

        ClusterStack clusterStack = new ClusterStack(app, "Cluster", vpcStack.getVpc());
        clusterStack.addDependency(vpcStack);

        Service01Stack service01 = new Service01Stack(app, "Cliente", clusterStack.getCluster());
        service01.addDependency(clusterStack);

        app.synth();
    }
}